package com.example.rsaconnect.RSADatabase;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.rsaconnect.ServiceProvider;

import java.util.ArrayList;
import java.util.concurrent.CancellationException;

@Database(entities = ServiceProvider.class, version = 1)
public abstract class ServiceProviderDB extends RoomDatabase {
    public abstract ServiceProviderDao serviceProviderDao();

    public static ServiceProviderDB instance;
    public static synchronized ServiceProviderDB getInstance(Context context){
        if(null==instance){
            instance = Room.databaseBuilder(context, ServiceProviderDB.class,"service_provider_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .addCallback(initialCallback)
                    .build();
        }
        return instance;
    }
    private static final RoomDatabase.Callback initialCallback = new RoomDatabase.Callback(){
        //private WorkManager workManager;
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new InitialAsyncTask(instance).execute();
//            workManager = WorkManager.getInstance();
//            workManager.enqueue(OneTimeWorkRequest.from(InitialWork.class));
        }
    };

    public static class InitialAsyncTask extends AsyncTask<Void,Void,Void>{
        private ServiceProviderDao serviceProviderDao;

        public InitialAsyncTask(ServiceProviderDB db) {
            this.serviceProviderDao = db.serviceProviderDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            ArrayList<ServiceProvider> allProvider = new ArrayList<>();
            allProvider.add(new ServiceProvider("Nguzo Car Reparation", "car repair service", "https://img.freepik.com/premium-vector/auto-repair-garage-logo-automotive-industry_160069-63.jpg",
                    "Kinondoni, Mwenge", 5));
            allProvider.add(new ServiceProvider("Yange Auto Service", "car repair service", "https://img.freepik.com/premium-vector/auto-repair-garage-logo-automotive-industry_160069-63.jpg",
                    "Makumbusho, Millenium", 5));
            allProvider.add(new ServiceProvider("Mechaworld Garage", "car repair services", "https://t4.ftcdn.net/jpg/03/76/13/91/360_F_376139191_Piz0irT1ssvcYiqiRuH8DqpiAjuYCc0R.jpg",
                    "Mikocheni, Kawe Road", 5));
            allProvider.add(new ServiceProvider("Nguzo Towing", "Car Tiowing", "https://img.freepik.com/premium-vector/towing-truck-logo-vector_498574-747.jpg", "Temeke, Mbagala Kuu",
                    5));
            for (ServiceProvider s : allProvider
            ) {
                serviceProviderDao.insert(s);
            }
            return null;
        }
    }

//    public class InitialWork extends Worker {
//        private ServiceProviderDao serviceProviderDao;
//
//        public InitialWork(@NonNull Context context, @NonNull WorkerParameters workerParams, ServiceProviderDao serviceProviderDao) {
//            super(context, workerParams);
//            this.serviceProviderDao = serviceProviderDao;
//        }
//
//        public InitialWork(
//                @NonNull Context appContext,
//                @NonNull WorkerParameters workerParams) {
//            super(appContext, workerParams);
//        }
//        @NonNull
//        @Override
//        public Result doWork() {
//                ArrayList<ServiceProvider> allProvider = new ArrayList<>();
//                allProvider.add(new ServiceProvider("Nguzo Car Reparation", "car repair service", "https://img.freepik.com/premium-vector/auto-repair-garage-logo-automotive-industry_160069-63.jpg",
//                        "Kinondoni, Mwenge", 5));
//                allProvider.add(new ServiceProvider("Mechaworld Garage", "car repair services", "https://t4.ftcdn.net/jpg/03/76/13/91/360_F_376139191_Piz0irT1ssvcYiqiRuH8DqpiAjuYCc0R.jpg",
//                        "Mikocheni, Kawe Road", 5));
//                allProvider.add(new ServiceProvider("Nguzo Towing", "Car Tiowing", "https://img.freepik.com/premium-vector/towing-truck-logo-vector_498574-747.jpg", "Temeke, Mbagala Kuu",
//                        5));
//                for (ServiceProvider s : allProvider
//                ) {
//                    serviceProviderDao.insert(s);
//                }
//                return Result.success();
//        }
//
//    }
}
