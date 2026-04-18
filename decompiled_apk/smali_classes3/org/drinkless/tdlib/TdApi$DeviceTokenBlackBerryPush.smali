.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenBlackBerryPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenBlackBerryPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x5cef0102


# instance fields
.field public token:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11418
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11419
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11409
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11410
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenBlackBerryPush;->token:Ljava/lang/String;

    .line 11411
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11415
    const v0, 0x5cef0102

    return v0
.end method
