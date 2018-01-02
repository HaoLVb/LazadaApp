package vn.edu.hust.lazadaapp.view.trangchu.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import vn.edu.hust.lazadaapp.LogManager;
import vn.edu.hust.lazadaapp.R;
import vn.edu.hust.lazadaapp.adapter.dientu.DienTuAdapter;
import vn.edu.hust.lazadaapp.model.entity.DienTu;
import vn.edu.hust.lazadaapp.model.entity.SanPham;
import vn.edu.hust.lazadaapp.model.entity.ThuongHieu;
import vn.edu.hust.lazadaapp.presenter.trangchu.dientu.DienTuPresenter;

public class DienTuFragment extends Fragment implements DienTuView {
    private View view;
    private RecyclerView recyclerView;
    private ArrayList<DienTu> dienTus;
    private DienTuPresenter dienTuPresenter;

    public DienTuFragment() {
        // Required empty public constructor
    }

    public static DienTuFragment newInstance() {
        DienTuFragment fragment = new DienTuFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_dientu, container, false);
        recyclerView = view.findViewById(R.id.recyclerView);
        dienTus = new ArrayList<>();
        dienTuPresenter = new DienTuPresenter(this);
        dienTuPresenter.layDanhSachDienTu();
        return view;
    }


    @Override
    public void hienThiThuongHieu(ArrayList<ThuongHieu> thuongHieus, ArrayList<SanPham> sanPhams) {

        DienTu dienTu = new DienTu();
        dienTu.setThuongHieus(thuongHieus);
        dienTu.setSanPhams(sanPhams);
        dienTus.add(dienTu);

        DienTuAdapter dienTuAdapter = new DienTuAdapter(getActivity(), dienTus);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(dienTuAdapter);
        dienTuAdapter.notifyDataSetChanged();
    }
}
