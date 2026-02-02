import PropTypes from "prop-types";

function ProductLine({name}) {

    return (
        <div style={{ padding: "2px", margin: "4px" }}>
            <li> {name} </li>
        </div>
    );
}

ProductLine.propTypes = {
    name: PropTypes.string.isRequired,
};

export default ProductLine;
