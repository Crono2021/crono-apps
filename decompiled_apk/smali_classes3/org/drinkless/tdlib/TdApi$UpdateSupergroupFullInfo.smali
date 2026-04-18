.class public Lorg/drinkless/tdlib/TdApi$UpdateSupergroupFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateSupergroupFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x19f5cd0e


# instance fields
.field public supergroupFullInfo:Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;

.field public supergroupId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35028
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35029
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$SupergroupFullInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "supergroupFullInfo"    # Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;

    .line 35018
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35019
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateSupergroupFullInfo;->supergroupId:J

    .line 35020
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateSupergroupFullInfo;->supergroupFullInfo:Lorg/drinkless/tdlib/TdApi$SupergroupFullInfo;

    .line 35021
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35025
    const v0, 0x19f5cd0e

    return v0
.end method
