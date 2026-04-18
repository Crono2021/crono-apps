.class public Lorg/drinkless/tdlib/TdApi$DeviceTokenWindowsPush;
.super Lorg/drinkless/tdlib/TdApi$DeviceToken;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DeviceTokenWindowsPush"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x5412bd71


# instance fields
.field public accessToken:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11526
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11527
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 11517
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$DeviceToken;-><init>()V

    .line 11518
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$DeviceTokenWindowsPush;->accessToken:Ljava/lang/String;

    .line 11519
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11523
    const v0, -0x5412bd71

    return v0
.end method
