package com.example.pritampc.retrofitgitex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;

import java.util.List;

/**
 * Created by pritamPC on 1/28/2018.
 */

public class GithubRepoAdapter extends ArrayAdapter<GithubRepo> {

    public GithubRepoAdapter(@NonNull Context context, int resource, @NonNull List<GithubRepo> objects) {
        super(context, resource, objects);
    }

}
