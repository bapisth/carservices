package com.urja.carservices;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.mikepenz.fontawesome_typeface_library.FontAwesome;
import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IProfile;

public class DashboardActivity extends AppCompatActivity {

    private Drawer mDrawer;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_dashboard);

        //Initialize toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Navigation Drawer
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName(R.string.drawer_item_home);
        PrimaryDrawerItem item2 = new SecondaryDrawerItem().withIdentifier(2).withName(R.string.drawer_item_settings);

        ProfileDrawerItem profiles1 = new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile));
        ProfileDrawerItem profiles2 = new ProfileDrawerItem().withName("Mike Penz").withEmail("mikepenz@gmail.com").withIcon(getResources().getDrawable(R.drawable.profile));
        AccountHeader headerResult = new AccountHeaderBuilder()
                .withActivity(this)
                .withHeaderBackground(R.drawable.user_drawer_bg)
                .addProfiles(
                        profiles1, profiles2
                )
                .withOnAccountHeaderListener(new AccountHeader.OnAccountHeaderListener() {
                    @Override
                    public boolean onProfileChanged(View view, IProfile profile, boolean currentProfile) {
                        return false;
                    }
                })
                .build();

        AccountHeader accountHeader = new AccountHeaderBuilder()
                .withActivity(this)
                .withDividerBelowHeader(true)
                .withTextColor(getResources().getColor(R.color.white))
                .withHeaderBackground(R.drawable.user_drawer_bg)
                .addProfiles(new ProfileDrawerItem()
                        .withName(mAuth.getCurrentUser().getDisplayName())
                        .withEmail(mAuth.getCurrentUser().getEmail())
                        .withIcon(FontAwesome.Icon.faw_user)

                ).build();

        mDrawer = new DrawerBuilder().withActivity(this)
                .addDrawerItems(item1, item2)
                .withAccountHeader(headerResult, true)
                .withToolbar(toolbar)
                .build();
    }
}
