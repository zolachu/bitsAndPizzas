package com.zolachu.bitsandpizzas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_order, container, false);
        MaterialToolbar toolbar = view.findViewById(R.id.toolbar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        FloatingActionButton fab = view.findViewById(R.id.fab);
        fab.setOnClickListener(v -> {
            RadioGroup group = view.findViewById(R.id.radio_group);
            int checkedId = group.getCheckedRadioButtonId();
            if (checkedId == -1) {
                // no item selected
                String message = "Please select pizza";
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            } else {
                String text = (checkedId == R.id.button_funghi) ? "funghi" : "diavolo";

                RadioButton button = view.findViewById(checkedId);
                Chip chipChilli = view.findViewById(R.id.chilli_oil);
                Chip chipParmesan = view.findViewById(R.id.parmesan);

                text += (chipChilli.isChecked()) ? ", extra chilli oil" : "";
                text += (chipParmesan.isChecked()) ? ", extra parmesan" : "";
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show();
            }
        });
        return view;
    }


}