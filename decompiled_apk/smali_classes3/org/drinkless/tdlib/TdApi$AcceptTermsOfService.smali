.class public Lorg/drinkless/tdlib/TdApi$AcceptTermsOfService;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "AcceptTermsOfService"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x7efe03e4


# instance fields
.field public termsOfServiceId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 8574
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8575
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 8565
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 8566
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$AcceptTermsOfService;->termsOfServiceId:Ljava/lang/String;

    .line 8567
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 8571
    const v0, 0x7efe03e4

    return v0
.end method
