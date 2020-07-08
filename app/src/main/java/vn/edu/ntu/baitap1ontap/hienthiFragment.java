package vn.edu.ntu.baitap1ontap;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class hienthiFragment extends Fragment {

   TextView hienthi;
   Button thoat;

    NavController navController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hienthi, container, false);
        addview(view);
        data();
        addevent();
        return view;
    }

    private void addevent() {
        thoat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navController.navigate(R.id.action_hienthiFragment_to_dienthongtinFragment);
            }
        });
    }

    private void data() {
        Bundle data = getArguments();
        String str = "Chúc mừng khách hàng: " + data.getString("ten") + "\n Ngày sinh: "
                + data.getString("ngaysinh") + "\n Đã đăng ký thành công dịch vụ: \n" + data.getString("dichvu")
                + "\n Hình thức thanh toán: " + data.getString("phuongthuc") + "\n Chúng tôi sẽ liên lạc với bạn qua số điện thoại: \n"
                + data.getString("sdt");
        hienthi.setText(str);
    }

    private void addview(View view) {
        hienthi = view.findViewById(R.id.textthongbao);
        thoat = view.findViewById(R.id.thoat);
        navController = NavHostFragment.findNavController(hienthiFragment.this);
    }
}