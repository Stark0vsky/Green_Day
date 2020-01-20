package com.dev.recyclica.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.dev.recyclica.R;
import com.google.android.material.bottomnavigation.BottomNavigationMenu;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import moxy.MvpAppCompatFragment;

public class MainMenuFragment extends MvpAppCompatFragment {

    public final static String TAG = "MainMenu";

    @BindView(R.id.bottomNavigationView)
    BottomNavigationView mBottomNavigation;

    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View v = inflater.inflate(R.layout.fragment_menu, container, false);
        unbinder = ButterKnife.bind(this, v);

        mBottomNavigation.setOnNavigationItemSelectedListener(menuItem -> {
            if (menuItem.getItemId() == R.id.fragment_map) {
                FragmentManager manager = getFragmentManager();
                if (manager != null) {
                    manager.beginTransaction()
                            .replace(R.id.main_container, new MapFragment(), MapFragment.TAG)
                            .commit();
                }
            }
            return true;
        });

        mBottomNavigation.setOnNavigationItemReselectedListener(menuItem -> {});

        return v;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
