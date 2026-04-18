.class public Lorg/drinkless/tdlib/TdApi$UpdateUserStatus;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateUserStatus"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x39211211


# instance fields
.field public status:Lorg/drinkless/tdlib/TdApi$UserStatus;

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 35128
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35129
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$UserStatus;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "userStatus"    # Lorg/drinkless/tdlib/TdApi$UserStatus;

    .line 35118
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 35119
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserStatus;->userId:J

    .line 35120
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateUserStatus;->status:Lorg/drinkless/tdlib/TdApi$UserStatus;

    .line 35121
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 35125
    const v0, 0x39211211

    return v0
.end method
