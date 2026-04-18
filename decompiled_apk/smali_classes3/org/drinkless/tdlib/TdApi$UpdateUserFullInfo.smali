.class public Lorg/drinkless/tdlib/TdApi$UpdateUserFullInfo;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUserFullInfo"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x30d34e9


# instance fields
.field public userFullInfo:Lorg/drinkless/tdlib/TdApi$UserFullInfo;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35088
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35089
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UserFullInfo;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "userFullInfo"    # Lorg/drinkless/tdlib/TdApi$UserFullInfo;

    .line 35078
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35079
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserFullInfo;->userId:J

    .line 35080
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserFullInfo;->userFullInfo:Lorg/drinkless/tdlib/TdApi$UserFullInfo;

    .line 35081
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35085
    const v0, -0x30d34e9

    return v0
.end method
