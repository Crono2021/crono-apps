.class public Lorg/drinkless/tdlib/TdApi$GetUserSupportInfo;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUserSupportInfo"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$UserSupportInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x74a59305


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13938
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13939
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13929
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13930
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetUserSupportInfo;->userId:J

    .line 13931
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13935
    const v0, 0x74a59305

    return v0
.end method
