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
import com.zolachu.bitsandpizzas.databinding.FragmentOrderBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link OrderFragment} factory method to
 * create an instance of this fragment.
 */
public class OrderFragment extends Fragment {
    private FragmentOrderBinding _binding = null;

    public FragmentOrderBinding binding;
    private FragmentOrderBinding getBinding() {
        return _binding;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        _binding = FragmentOrderBinding.inflate(inflater, container, false);

        binding = getBinding();
        View view = binding.getRoot();
        MaterialToolbar toolbar = binding.toolbar;

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);


        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(v -> {
            RadioGroup group = binding.radioGroup;
            int checkedId = group.getCheckedRadioButtonId();
            if (checkedId == -1) {
                // no item selected
                String message = "Please select pizza";
                Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
            } else {
                String text = (checkedId == R.id.button_funghi) ? "funghi" : "diavolo";

                Chip chipChilli = binding.chilliOil;
                Chip chipParmesan = binding.parmesan;

                text += (chipChilli.isChecked()) ? ", extra chilli oil" : "";
                text += (chipParmesan.isChecked()) ? ", extra parmesan" : "";
                Snackbar.make(fab, text, Snackbar.LENGTH_LONG).show();
            }
        });
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        _binding = null;
    }
}