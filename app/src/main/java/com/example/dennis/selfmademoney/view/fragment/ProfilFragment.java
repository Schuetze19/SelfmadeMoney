package com.example.dennis.selfmademoney.view.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dennis.selfmademoney.R;
import com.example.dennis.selfmademoney.dao.UserDao;
import com.example.dennis.selfmademoney.model.User;
import com.example.dennis.selfmademoney.util.ClipboardUtil;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;

import de.hdodenhof.circleimageview.CircleImageView;
import jp.wasabeef.picasso.transformations.CropCircleTransformation;

public class ProfilFragment extends Fragment {

    private CircleImageView profilBild;
    private TextView txtUsername, txtEmail, txtMitgliedSeit, txtFullName, txtPlace;
    private EditText editDescription;
    private ImageView emailToClip, usernameToClip;
    private final String clipboardkey_email = "email";
    private final String clipboardkey_username = "username";
    private final String datePattern = "dd.MM.yyyy";
    private final UserDao userDao = new UserDao();
    private User user;

    public ProfilFragment() {}

    public static ProfilFragment newInstance() {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }

    public static ProfilFragment newInstance(String param1, String param2) {
        ProfilFragment fragment = new ProfilFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profil, container, false);
        profilBild = (CircleImageView) view.findViewById(R.id.profilBild);
        txtUsername = (TextView) view.findViewById(R.id.txtUsername);
        txtMitgliedSeit = (TextView) view.findViewById(R.id.txtMitgliedSeit);
        txtEmail = (TextView) view.findViewById(R.id.txtEmail);
        emailToClip = (ImageView) view.findViewById(R.id.emailToClip);
        usernameToClip = (ImageView) view.findViewById(R.id.usernameToClip);
        txtFullName = (TextView) view.findViewById(R.id.txtFullName);
        txtPlace = (TextView) view.findViewById(R.id.txtPlace);
        editDescription = (EditText) view.findViewById(R.id.editDescription);

        String userId = getActivity().getIntent().getStringExtra(getString(R.string.intent_userId));
        if(!userId.isEmpty()) {
            userDao.getDatabaseReference().child(userId).addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    user = dataSnapshot.getValue(User.class);
                    txtUsername.setText(user.getUsername());
                    txtMitgliedSeit.setText(user.getMitgliedSeit());
                    txtEmail.setText(user.getEmail());
                    txtFullName.setText(user.getFullName() + " / " + user.getGeborenAm());
                    txtPlace.setText(user.getWohnort());
                    editDescription.setText(user.getBeschreibung());
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            emailToClip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardUtil.copyToClipboard(getActivity(), clipboardkey_email, user.getEmail());
                    Toast.makeText(getContext(), user.getEmail() + " kopiert", Toast.LENGTH_SHORT).show();
                }
            });

            usernameToClip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ClipboardUtil.copyToClipboard(getActivity(), clipboardkey_username, user.getUsername());
                    Toast.makeText(getContext(), user.getUsername() + " kopiert", Toast.LENGTH_SHORT).show();
                }
            });
        }

        Picasso.get()
                .load(R.drawable.ic_portrait_white_48dp)
                .placeholder(R.drawable.ic_portrait_white_48dp)
                .error(R.drawable.ic_portrait_white_48dp)
                .transform(new CropCircleTransformation())
                .into(profilBild);
        return view;
    }
}
