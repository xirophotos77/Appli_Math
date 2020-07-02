package com.example.appli_math;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;

import com.example.appli_math.ui.calculation.CalculationFragment;
import com.example.appli_math.ui.derivation.DerivationFragment;
import com.example.appli_math.ui.function.FunctionFragment;
import com.example.appli_math.ui.pythagoras.PythagorasFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private DrawerLayout dLayout;
    private Fragment frag_calculation,frag_derivation,frag_function,frag_pythagoras,currentFragment;
    private FragmentTransaction fragTransaction;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);

        //Wichtige Methoden aufruf

        initFragment();

        /* TODO -> Sind Zeilen 53-61 notwendig -> bei späteren Sprints prüfen*/
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    private void updateFragment() {
        fragTransaction = getSupportFragmentManager().beginTransaction();
        fragTransaction.replace(R.id.fragment_container_view_tag, currentFragment);

        fragTransaction.commit();
    }

    //Fragment erzeugen
    private void initFragment(){
        frag_calculation = new CalculationFragment();
        frag_pythagoras = new PythagorasFragment();
        frag_function = new FunctionFragment();
        frag_derivation = new DerivationFragment();
    }


    //Klick auf Navibar -> neues Fragment öffnen
    public boolean onNavigationItemSelected(MenuItem menu){
        switch(menu.getItemId()){
            case R.id.nav_calculation:
                break;
            case R.id.nav_pythagoras:
                break;
            case R.id.nav_function:
                break;
            case R.id.nav_derivation:
                break;
        }
        toggleNavigationDrawer();
        return true;
    }

    public void toggleNavigationDrawer() {
        if (dLayout.isDrawerOpen(GravityCompat.END)) {
            dLayout.closeDrawer(GravityCompat.END);
        } else {
            dLayout.openDrawer(GravityCompat.END);
        }

    }

}
