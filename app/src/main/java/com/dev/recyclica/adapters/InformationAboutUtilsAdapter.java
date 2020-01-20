package com.dev.recyclica.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.dev.recyclica.R;
import com.dev.recyclica.pojo.InformationAboutUtil;

import java.util.ArrayList;
import java.util.List;

public class InformationAboutUtilsAdapter extends RecyclerView.Adapter<InformationAboutUtilsAdapter.ViewHolderInformation> {

    private List<InformationAboutUtil> informations = new ArrayList<>();

    public void setInformationsList(List<InformationAboutUtil> newList) {
        informations.addAll(newList);

        notifyDataSetChanged();
    }

    public void addInformation(InformationAboutUtil informationAboutUtil) {
        informations.add(informationAboutUtil);
        notifyItemChanged(0);
    }

    @NonNull
    @Override
    public ViewHolderInformation onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.util_view, parent, false);

        return new ViewHolderInformation(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInformation holder, int position) {
        holder.bind(informations.get(position));
    }

    @Override
    public int getItemCount() {
        return informations.size();
    }

    class ViewHolderInformation extends RecyclerView.ViewHolder {

        private TextView mName;
        private TextView mBonuses;
        private TextView mShipPoints;

        public ViewHolderInformation(@NonNull View itemView) {
            super(itemView);
            mName = itemView.findViewById(R.id.tv_util_name);
            mShipPoints = itemView.findViewById(R.id.tv_util_description);
            mBonuses = itemView.findViewById(R.id.tv_bonuses);
        }

        public void bind(InformationAboutUtil informationAboutUtil) {
            mName.setText(informationAboutUtil.getName());
            mShipPoints.setText(String.valueOf(informationAboutUtil.getShipCounts()));
            mBonuses.setText(String.valueOf(informationAboutUtil.getPoints()));
        }

    }
}