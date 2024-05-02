/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.rentedbook;

import dao.RentedBookDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.table.DefaultTableModel;
import model.Bill;
import model.BookError;
import model.PaidBook;
import model.PayBill;
import model.RentedBook;

/**
 *
 * @author LENOVO
 */
public class SearchRentedBookFrm extends javax.swing.JFrame implements ActionListener {

    /**
     * Creates new form SearchFreeRoomFrm
     */
    private Bill bill;
    private ArrayList<RentedBook> ListRentedBook;
    private ArrayList<PayBill> ListPayBill;

    public SearchRentedBookFrm(Bill b) {
        initComponents();
        setTitle("Search Rented Book");
        txtUserFullName.setText(b.getUser().getName());
        txtRole.setText(b.getUser().getPosition());
        txtNameClient.setText(b.getClient().getName());
        this.bill = b;

        btnSearch.addActionListener(this);
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id RentedBook");
        model.addColumn("Name");
        model.addColumn("Rented Day");
        model.addColumn("Payment Date");
        model.addColumn("Total");
        model.addColumn("Note");
        tblPaidBook.setModel(model);

        ListPayBill = new ArrayList<PayBill>();

        LocalDate currentDate = LocalDate.now();
        ZoneId systemTimeZone = ZoneId.systemDefault();
        ZonedDateTime zonedDateTime = currentDate.atStartOfDay(systemTimeZone);
        Date utilDate = Date.from(zonedDateTime.toInstant());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        tblRentedBook.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                PaidBook paidbook = new PaidBook();
                PayBill paybill = new PayBill();
                int column = tblRentedBook.getColumnModel().
                        getColumnIndexAtX(e.getX()); 
                int row = e.getY() / tblRentedBook.getRowHeight(); 
                
                if (row < tblRentedBook.getRowCount() && row >= 0
                        && column < tblRentedBook.getColumnCount() && column >= 0) {

                    RentedBook book = ListRentedBook.get(row);
                    showdata(ListRentedBook, row);
                    model.addRow(new Object[]{book.getId(), book.getBook().getName(), sdf.format(book.getRentingDate()), sdf.format(utilDate), 
                        tinhtien(sdf.format(book.getRentingDate()), sdf.format(utilDate), book.getPriceByDay()), book.getNote()});
                    paidbook.setRentedbook(book);
                    paidbook.setPaymentDate(utilDate);
                    paidbook.setSubtotal(tinhtien(sdf.format(book.getRentingDate()), sdf.format(utilDate), book.getPriceByDay()));
                    paidbook.setDes(book.getNote());
                    paybill.setPaidbook(paidbook);
                    paybill.setBookerror(book.getBookerror());
                    ListPayBill.add(paybill);
                }
            }
        });
        
        btnEnterStatusBook.addActionListener((e) ->
        {
            this.bill.setListpaybill(ListPayBill);
            (new EnterStatusBookFrm(this.bill)).setVisible(true);
            this.dispose();   
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUserLabel = new javax.swing.JLabel();
        txtUserFullName = new javax.swing.JLabel();
        txtRoleLabel = new javax.swing.JLabel();
        txtRole = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtNameClient = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblRentedBook = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        btnEnterStatusBook = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblPaidBook = new javax.swing.JTable();
        btnSearch = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Name's Client:");

        jLabel3.setText("Rented Book:");

        txtUserLabel.setText("User:");

        txtUserFullName.setText("jLabel6");

        txtRoleLabel.setText("Role:");

        txtRole.setText("jLabel7");

        jLabel5.setText("Search Rented Book ");

        txtNameClient.setText("jLabel2");

        tblRentedBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Name", "Type", "Renting Day", "Payment Date", "Price By Day", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane2.setViewportView(tblRentedBook);

        jLabel4.setText("Paid Book:");

        btnEnterStatusBook.setText("Confirm Paid Book(s)");

        tblPaidBook.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "id RentedBook", "Name", "Renting Day", "Payment Date", "Total", "Note"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblPaidBook);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 677, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(346, 346, 346)
                        .addComponent(btnEnterStatusBook, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEnterStatusBook)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );

        btnSearch.setText("Search");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 234, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(318, 318, 318)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(270, 270, 270)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNameClient)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnSearch))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtUserLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtUserFullName, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtRoleLabel)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtRole, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtUserLabel)
                    .addComponent(txtUserFullName)
                    .addComponent(txtRoleLabel)
                    .addComponent(txtRole))
                .addGap(29, 29, 29)
                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNameClient)
                    .addComponent(btnSearch))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEnterStatusBook;
    private javax.swing.JButton btnSearch;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tblPaidBook;
    private javax.swing.JTable tblRentedBook;
    private javax.swing.JLabel txtNameClient;
    private javax.swing.JLabel txtRole;
    private javax.swing.JLabel txtRoleLabel;
    private javax.swing.JLabel txtUserFullName;
    private javax.swing.JLabel txtUserLabel;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent e) {
        btnSearch.setEnabled(false);
        RentedBookDAO rentedbookdao = new RentedBookDAO();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        ListRentedBook = new ArrayList<RentedBook>();
        ListRentedBook = rentedbookdao.searchRentedBook(this.bill.getClient());

        String data[][] = new String[ListRentedBook.size()][7];
        for (int i = 0; i < ListRentedBook.size(); i++) {
            RentedBook bed = ListRentedBook.get(i);
            data[i][0] = bed.getId()+"";
            data[i][1] = bed.getBook().getName();
            data[i][2] = bed.getBook().getType();
            data[i][3] = sdf.format(bed.getRentingDate())+ "";
            data[i][4] = sdf.format(bed.getPaymentDate())+ "";
            data[i][5] = bed.getPriceByDay() + "";
            data[i][6] = bed.getNote();
        }
        String[] columnNames = {"Id", "Name", "Type", "Renting Day", "Payment Date", "Price By Day", "Note"};
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tblRentedBook.setModel(dtm);
    }
    public float tinhtien(String start, String end, float tien)
    {
        float result = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {

            Date startDate = sdf.parse(start);
            Date endDate = sdf.parse(end);

            long startValue = startDate.getTime();
            long endValue = endDate.getTime();
            long tmp = Math.abs(startValue- endValue);

            long days = tmp/(24*60*60*1000);

            result = days*tien;

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return result;
    }
    public void showdata(ArrayList<RentedBook> List, int select)
    {
        ArrayList<RentedBook> ListNew = new ArrayList<RentedBook>();
        for (int i =0; i<List.size();i++)
        {
            if(i != select) ListNew.add(List.get(i));
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String data[][] = new String[ListNew.size()][7];
        for (int i = 0; i < ListNew.size(); i++) {
            RentedBook bed = ListNew.get(i);
            data[i][0] = bed.getId()+"";
            data[i][1] = bed.getBook().getName();
            data[i][2] = bed.getBook().getType();
            data[i][3] = sdf.format(bed.getRentingDate())+ "";
            data[i][4] = sdf.format(bed.getPaymentDate())+ "";
            data[i][5] = bed.getPriceByDay() + "";
            data[i][6] = bed.getNote();
        }
        this.ListRentedBook = ListNew;
        String[] columnNames = {"Id", "Name", "Type", "Renting Day", "Payment Date", "Price By Day", "Note"};
        DefaultTableModel dtm = new DefaultTableModel(data, columnNames);
        tblRentedBook.setModel(dtm);
    }
}