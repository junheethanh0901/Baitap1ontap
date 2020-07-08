package vn.edu.ntu.baitap1ontap;

import android.app.DatePickerDialog;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import java.util.Calendar;




public class dienthongtinFragment extends Fragment {
    EditText hoten, ngaysinh, sdt, diachi;
    ImageView imglich;
    RadioButton tienmat, nganhang, vidientu;
    Spinner spinner;
    Button dangky;

    String ten, ngsinh, dc, phuongthuc, dichvu, dt;
    NavController navController;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dienthongtin, container, false);
        addview(view);
        data();
        addevent();
        return view;
    }

    private void addevent() {
        dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ten = hoten.getText().toString();
                ngsinh = ngaysinh.getText().toString();
                dt = sdt.getText().toString();
                dc = diachi.getText().toString();

                if (tienmat.isChecked())
                {
                    phuongthuc = "Tiền mặt";
                }

                if (nganhang.isChecked())
                {
                    phuongthuc = "Ngân hàng";
                }

                if (vidientu.isChecked())
                {
                    phuongthuc = "Ví điện tử";
                }

                dichvu = spinner.getSelectedItem().toString();

                Bundle data = new Bundle();
                data.putString("hoten",ten);
                data.putString("ngaysinh",ngsinh);
                data.putString("sdt",dt);
                data.putString("diachi",dc);
                data.putString("dichvu",dichvu);
                data.putString("phuongthuc",phuongthuc);
                navController.navigate(R.id.action_dienthongtinFragment_to_hienthiFragment,data);
            }
        });

    }

    private void data() {
        imglich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();

                DatePickerDialog.OnDateSetListener listener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        StringBuilder builder = new StringBuilder();
                        builder.append(year)
                                .append("-")
                                .append(++month)
                                .append("-")
                                .append(dayOfMonth);
                        ngaysinh.setText(builder.toString());
                    }
                };
                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),listener
                        ,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });


//tao mang chua gia tri trong spinner
        String[] dichvu= new String[]{"Truyền hình số", "Truyền hình cáp","FPT"};

//tao adapter cho mang gia tri
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(dienthongtinFragment.this.getActivity(),
                R.layout.support_simple_spinner_dropdown_item,dichvu);

//gan adapter cho spinner
        spinner.setAdapter(arrayAdapter);
    }

    private void addview(View view) {
        hoten = view.findViewById(R.id.edithoten);
        ngaysinh = view.findViewById(R.id.editngaysinh);
        sdt = view.findViewById(R.id.editsdt);
        diachi = view.findViewById(R.id.editdiachi);
        imglich = view.findViewById(R.id.imglich);
        tienmat = view.findViewById(R.id.tienmat);
        nganhang = view.findViewById(R.id.nganhang);
        vidientu = view.findViewById(R.id.vidientu);
        spinner = view.findViewById(R.id.spinner);
        dangky = view.findViewById(R.id.dangky);

        navController = NavHostFragment.findNavController(dienthongtinFragment.this);
    }
}