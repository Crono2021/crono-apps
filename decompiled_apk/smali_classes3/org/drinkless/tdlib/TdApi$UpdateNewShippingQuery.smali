.class public Lorg/drinkless/tdlib/TdApi$UpdateNewShippingQuery;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateNewShippingQuery"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x29584672


# instance fields
.field public id:J

.field public invoicePayload:Ljava/lang/String;

.field public senderUserId:J

.field public shippingAddress:Lorg/drinkless/tdlib/TdApi$Address;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 46206
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46207
    return-void
.end method

.method public constructor <init>(JJLjava/lang/String;Lorg/drinkless/tdlib/TdApi$Address;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "str"    # Ljava/lang/String;
    .param p6, "address"    # Lorg/drinkless/tdlib/TdApi$Address;

    .line 46194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 46195
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewShippingQuery;->id:J

    .line 46196
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewShippingQuery;->senderUserId:J

    .line 46197
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewShippingQuery;->invoicePayload:Ljava/lang/String;

    .line 46198
    iput-object p6, p0, Lorg/drinkless/tdlib/TdApi$UpdateNewShippingQuery;->shippingAddress:Lorg/drinkless/tdlib/TdApi$Address;

    .line 46199
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 46203
    const v0, 0x29584672

    return v0
.end method
