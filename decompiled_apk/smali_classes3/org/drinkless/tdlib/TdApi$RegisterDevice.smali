.class public Lorg/drinkless/tdlib/TdApi$RegisterDevice;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "RegisterDevice"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$PushReceiverId;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x15d21277


# instance fields
.field public deviceToken:Lorg/drinkless/tdlib/TdApi$DeviceToken;

.field public otherUserIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29868
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29869
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$DeviceToken;[J)V
    .locals 0
    .param p1, "deviceToken"    # Lorg/drinkless/tdlib/TdApi$DeviceToken;
    .param p2, "jArr"    # [J

    .line 29858
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29859
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$RegisterDevice;->deviceToken:Lorg/drinkless/tdlib/TdApi$DeviceToken;

    .line 29860
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$RegisterDevice;->otherUserIds:[J

    .line 29861
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29865
    const v0, 0x15d21277

    return v0
.end method
