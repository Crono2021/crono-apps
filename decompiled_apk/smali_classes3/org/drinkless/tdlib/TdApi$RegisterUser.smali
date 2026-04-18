.class public Lorg/drinkless/tdlib/TdApi$RegisterUser;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RegisterUser"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x3c55ad14


# instance fields
.field public disableNotification:Z

.field public firstName:Ljava/lang/String;

.field public lastName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 39426
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39427
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "z8"    # Z

    .line 39415
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 39416
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RegisterUser;->firstName:Ljava/lang/String;

    .line 39417
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RegisterUser;->lastName:Ljava/lang/String;

    .line 39418
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$RegisterUser;->disableNotification:Z

    .line 39419
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 39423
    const v0, -0x3c55ad14

    return v0
.end method
