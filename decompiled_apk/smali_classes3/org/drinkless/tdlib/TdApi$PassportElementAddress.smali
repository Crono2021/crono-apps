.class public Lorg/drinkless/tdlib/TdApi$PassportElementAddress;
.super Lorg/drinkless/tdlib/TdApi$PassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PassportElementAddress"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x2ea5e9d0


# instance fields
.field public address:Lorg/drinkless/tdlib/TdApi$Address;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 17376
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17377
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$Address;)V
    .locals 0
    .param p1, "address"    # Lorg/drinkless/tdlib/TdApi$Address;

    .line 17367
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$PassportElement;-><init>()V

    .line 17368
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$PassportElementAddress;->address:Lorg/drinkless/tdlib/TdApi$Address;

    .line 17369
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 17373
    const v0, -0x2ea5e9d0

    return v0
.end method
