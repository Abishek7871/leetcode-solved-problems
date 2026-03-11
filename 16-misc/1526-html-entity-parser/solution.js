var entityParser = function(text) {
    const entities = {
        "&quot;": '"',
        "&apos;": "'",
        "&amp;": "&",
        "&gt;": ">",
        "&lt;": "<",
        "&frasl;": "/"
    };

    const pattern = /&[^;&\s]+;/g;

    return text.replace(pattern, match => {
        return entities[match] || match;
    });
};
