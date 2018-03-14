
package dilan.dublinbike.classes;


import android.os.Parcel;
import android.os.Parcelable;

public class Station implements Parcelable {

    private int number;
    private String contract_name;
    private String name;
    private String address;
    private Position position;
    private boolean banking;
    private boolean bonus;
    private String status;
    private int bike_stands;
    private int available_bike_stands;
    private int availableBikes;
    private long last_update;

    protected Station(Parcel in) {
        number = in.readInt();
        contract_name = in.readString();
        name = in.readString();
        address = in.readString();
        position = in.readParcelable(Position.class.getClassLoader());
        banking = in.readByte() != 0;
        bonus = in.readByte() != 0;
        status = in.readString();
        bike_stands = in.readInt();
        available_bike_stands = in.readInt();
        availableBikes = in.readInt();
        last_update = in.readLong();
    }

    public static final Creator<Station> CREATOR = new Creator<Station>() {
        @Override
        public Station createFromParcel(Parcel in) {
            return new Station(in);
        }

        @Override
        public Station[] newArray(int size) {
            return new Station[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getContract_name() {
        return contract_name;
    }

    public void setContractName(String contract_name) {
        this.contract_name = contract_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean isBanking() {
        return banking;
    }

    public void setBanking(boolean banking) {
        this.banking = banking;
    }

    public boolean isBonus() {
        return bonus;
    }

    public void setBonus(boolean bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getBike_stands() {
        return bike_stands;
    }

    public void setBike_stands(int bike_stands) {
        this.bike_stands = bike_stands;
    }


    public int getAvailable_bike_stands() {
        return available_bike_stands;
    }

    public void setAvailable_bike_stands(int available_bike_stands) {
        this.available_bike_stands = available_bike_stands;
    }

    public int getAvailableBikes() {
        return availableBikes;
    }

    public void setAvailableBikes(int availableBikes) {
        this.availableBikes = availableBikes;
    }

    public long getLast_update() {
        return last_update;
    }

    public void setLast_update(long last_update) {
        this.last_update = last_update;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(number);
        parcel.writeString(contract_name);
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeParcelable(position, i);
        parcel.writeByte((byte) (banking ? 1 : 0));
        parcel.writeByte((byte) (bonus ? 1 : 0));
        parcel.writeString(status);
        parcel.writeInt(bike_stands);
        parcel.writeInt(available_bike_stands);
        parcel.writeInt(availableBikes);
        parcel.writeLong(last_update);
    }
}
