package com.app.reach.reach.RealmCRUD
/**
 * Created by tenzin on 4/4/16.
 */
public class CrudService {
   /* private Realm realm;
    private RealmConfiguration realmConfig;

    public void SaveCompanies(SuccessfulGetCompanyEvent event, Context context) {

        List<Company> company = event
        realmConfig = new RealmConfiguration.Builder(context.getApplicationContext()).build();
        // Open the Realm for the UI thread.
        realm = Realm.getInstance(realmConfig);

        company.each {
            // Add a person
            realm.beginTransaction();
            Company singleCompany = realm.createObject(Company.class);
            singleCompany.setId(it.getId());
            singleCompany.setCompanyName(it.getCompanyName())
            singleCompany.setCompanyCode(it.getCompanyCode())
            singleCompany.setActive(it.getActive())
            // When the transaction is committed, all changes a synced to disk.
            realm.commitTransaction();
            singleCompany = realm.where(Company.class).findFirst();
            Log.d("Single Companies", ""+singleCompany.dump())
        }

    }
*/
}
