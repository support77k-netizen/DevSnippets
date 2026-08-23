// Dashboard Stat Card Generator | UIVault
// Java - builds stat cards + a simple bar chart programmatically

public class DashboardBuilder {

    public static View buildStatCard(Context ctx, String label, String value, int color) {
        CardView card = new CardView(ctx);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(0, 90);
        lp.weight = 1;
        lp.setMargins(8, 0, 8, 0);
        card.setLayoutParams(lp);
        card.setRadius(18 * ctx.getResources().getDisplayMetrics().density);
        card.setCardBackgroundColor(Color.parseColor("#1A1D24"));
        card.setCardElevation(0);

        LinearLayout inner = new LinearLayout(ctx);
        inner.setOrientation(LinearLayout.VERTICAL);
        inner.setPadding(24, 20, 24, 20);

        View dot = new View(ctx);
        dot.setLayoutParams(new LinearLayout.LayoutParams(20, 20));
        GradientDrawable dotBg = new GradientDrawable();
        dotBg.setShape(GradientDrawable.OVAL);
        dotBg.setColor(color);
        dot.setBackground(dotBg);

        TextView valueView = new TextView(ctx);
        valueView.setText(value);
        valueView.setTextColor(Color.parseColor("#F5F6FA"));
        valueView.setTextSize(20);
        valueView.setTypeface(null, Typeface.BOLD);

        TextView labelView = new TextView(ctx);
        labelView.setText(label);
        labelView.setTextColor(Color.parseColor("#9CA3AF"));
        labelView.setTextSize(12);

        inner.addView(dot);
        inner.addView(valueView);
        inner.addView(labelView);
        card.addView(inner);
        return card;
    }

    // Usage:
    // LinearLayout row = findViewById(R.id.statsRow);
    // row.addView(buildStatCard(this, "Sales", "$12.4k", Color.parseColor("#00D9C0")));
    // row.addView(buildStatCard(this, "Orders", "342", Color.parseColor("#6C5CE7")));
}
