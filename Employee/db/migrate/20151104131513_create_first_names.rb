class CreateFirstNames < ActiveRecord::Migration
  def change
    create_table :first_names do |t|
      t.string :string
      t.string :LastName
      t.string :DoB
      t.string :date

      t.timestamps null: false
    end
  end
end
