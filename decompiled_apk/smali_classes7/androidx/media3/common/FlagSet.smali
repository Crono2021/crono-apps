.class public final Landroidx/media3/common/FlagSet;
.super Ljava/lang/Object;
.source "FlagSet.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Landroidx/media3/common/FlagSet$Builder;
    }
.end annotation


# instance fields
.field private final flags:Landroid/util/SparseBooleanArray;


# direct methods
.method private constructor <init>(Landroid/util/SparseBooleanArray;)V
    .locals 0
    .param p1, "flags"    # Landroid/util/SparseBooleanArray;

    .line 170
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 171
    iput-object p1, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    .line 172
    return-void
.end method

.method synthetic constructor <init>(Landroid/util/SparseBooleanArray;Landroidx/media3/common/FlagSet$1;)V
    .locals 0
    .param p1, "x0"    # Landroid/util/SparseBooleanArray;
    .param p2, "x1"    # Landroidx/media3/common/FlagSet$1;

    .line 36
    invoke-direct {p0, p1}, Landroidx/media3/common/FlagSet;-><init>(Landroid/util/SparseBooleanArray;)V

    return-void
.end method


# virtual methods
.method public contains(I)Z
    .locals 1
    .param p1, "flag"    # I

    .line 181
    iget-object v0, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v0

    return v0
.end method

.method public varargs containsAny([I)Z
    .locals 5
    .param p1, "flags"    # [I

    .line 191
    array-length v0, p1

    const/4 v1, 0x0

    move v2, v1

    :goto_0
    if-ge v2, v0, :cond_1

    aget v3, p1, v2

    .line 192
    .local v3, "flag":I
    invoke-virtual {p0, v3}, Landroidx/media3/common/FlagSet;->contains(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 193
    const/4 v0, 0x1

    return v0

    .line 191
    .end local v3    # "flag":I
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 196
    :cond_1
    return v1
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 6
    .param p1, "o"    # Ljava/lang/Object;

    .line 218
    const/4 v0, 0x1

    if-ne p0, p1, :cond_0

    .line 219
    return v0

    .line 221
    :cond_0
    instance-of v1, p1, Landroidx/media3/common/FlagSet;

    const/4 v2, 0x0

    if-nez v1, :cond_1

    .line 222
    return v2

    .line 224
    :cond_1
    move-object v1, p1

    check-cast v1, Landroidx/media3/common/FlagSet;

    .line 225
    .local v1, "that":Landroidx/media3/common/FlagSet;
    sget v3, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v4, 0x18

    if-ge v3, v4, :cond_5

    .line 227
    invoke-virtual {p0}, Landroidx/media3/common/FlagSet;->size()I

    move-result v3

    invoke-virtual {v1}, Landroidx/media3/common/FlagSet;->size()I

    move-result v4

    if-eq v3, v4, :cond_2

    .line 228
    return v2

    .line 230
    :cond_2
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/FlagSet;->size()I

    move-result v4

    if-ge v3, v4, :cond_4

    .line 231
    invoke-virtual {p0, v3}, Landroidx/media3/common/FlagSet;->get(I)I

    move-result v4

    invoke-virtual {v1, v3}, Landroidx/media3/common/FlagSet;->get(I)I

    move-result v5

    if-eq v4, v5, :cond_3

    .line 232
    return v2

    .line 230
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 235
    .end local v3    # "i":I
    :cond_4
    return v0

    .line 237
    :cond_5
    iget-object v0, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    iget-object v2, v1, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, v2}, Landroid/util/SparseBooleanArray;->equals(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public get(I)I
    .locals 2
    .param p1, "index"    # I

    .line 212
    const/4 v0, 0x0

    invoke-virtual {p0}, Landroidx/media3/common/FlagSet;->size()I

    move-result v1

    invoke-static {p1, v0, v1}, Landroidx/media3/common/util/Assertions;->checkIndex(III)I

    .line 213
    iget-object v0, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseBooleanArray;->keyAt(I)I

    move-result v0

    return v0
.end method

.method public hashCode()I
    .locals 4

    .line 243
    sget v0, Landroidx/media3/common/util/Util;->SDK_INT:I

    const/16 v1, 0x18

    if-ge v0, v1, :cond_1

    .line 245
    invoke-virtual {p0}, Landroidx/media3/common/FlagSet;->size()I

    move-result v0

    .line 246
    .local v0, "hashCode":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p0}, Landroidx/media3/common/FlagSet;->size()I

    move-result v2

    if-ge v1, v2, :cond_0

    .line 247
    mul-int/lit8 v2, v0, 0x1f

    invoke-virtual {p0, v1}, Landroidx/media3/common/FlagSet;->get(I)I

    move-result v3

    add-int v0, v2, v3

    .line 246
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 249
    .end local v1    # "i":I
    :cond_0
    return v0

    .line 251
    .end local v0    # "hashCode":I
    :cond_1
    iget-object v0, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->hashCode()I

    move-result v0

    return v0
.end method

.method public size()I
    .locals 1

    .line 201
    iget-object v0, p0, Landroidx/media3/common/FlagSet;->flags:Landroid/util/SparseBooleanArray;

    invoke-virtual {v0}, Landroid/util/SparseBooleanArray;->size()I

    move-result v0

    return v0
.end method
