package libreria;

import java.util.ArrayList;

public class Administrator extends User {
    private ArrayList<Permissions> permissions;
    private boolean isSuperAdmin;

    public Administrator(Profile profile, String username, String password, boolean isSuperAdmin) {
        super(profile, username, password);
        this.isSuperAdmin = isSuperAdmin;
        this.permissions = new ArrayList<>();
    }

    public boolean isSuperAdmin() {
        return isSuperAdmin;
    }

    public ArrayList<Permissions> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<Permissions> permissions) {
        this.permissions = permissions;
    }
}

