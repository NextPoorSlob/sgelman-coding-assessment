-- noinspection SqlNoDataSourceInspectionForFile

BEGIN;

CREATE TABLE products
(
    product_id   SERIAL       PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL UNIQUE
);

INSERT INTO products (product_name) VALUES
    ('Refrigerator Motor'),
    ('Washing Machine Pump'),
    ('Microwave Oven'),
    ('Dishwasher Heater'),
    ('Air Conditioner Compressor'),
    ('Vacuum Cleaner Motor'),
    ('Ceiling Fan Motor'),
    ('Blender Motor'),
    ('Toaster Heating Element'),
    ('Coffee Maker Pump'),
    ('Food Processor Motor'),
    ('Electric Kettle Heating Element'),
    ('Rice Cooker Motor'),
    ('Slow Cooker Heating Element'),
    ('Juicer Motor'),
    ('Wurlitzer Electric Piano Motor'),
    ('Electric Guitar Pickup'),
    ('Drum Machine Motor'),
    ('Synthesizer Oscillator'),
    ('Bass Guitar Amplifier');
COMMIT;
