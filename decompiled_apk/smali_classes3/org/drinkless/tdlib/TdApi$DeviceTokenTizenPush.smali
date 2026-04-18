.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenTizenPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenTizenPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x510f25cd


# instance fields
.field public regId:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11490
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11491
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11481
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11482
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenTizenPush;->regId:Ljava/lang/String;

    .line 11483
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11487
    const v0, -0x510f25cd

    return v0
.end method
