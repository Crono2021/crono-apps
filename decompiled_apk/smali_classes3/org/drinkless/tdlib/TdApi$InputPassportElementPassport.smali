.class public Lorg/drinkless/tdlib/TdApi$InputPassportElementPassport;
.super Lorg/drinkless/tdlib/TdApi$InputPassportElement;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InputPassportElementPassport"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1d9fca9c


# instance fields
.field public passport:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 15036
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15037
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;)V
    .locals 0
    .param p1, "inputIdentityDocument"    # Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 15027
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$InputPassportElement;-><init>()V

    .line 15028
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$InputPassportElementPassport;->passport:Lorg/drinkless/tdlib/TdApi$InputIdentityDocument;

    .line 15029
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 15033
    const v0, -0x1d9fca9c

    return v0
.end method
