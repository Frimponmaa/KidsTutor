json.array!(@first_names) do |first_name|
  json.extract! first_name, :id, :string, :LastName, :DoB, :date
  json.url first_name_url(first_name, format: :json)
end
