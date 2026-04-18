.class public Lorg/drinkless/tdlib/TdApi$GetUser;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUser"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$User;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x42999c0b


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 13884
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13885
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 13875
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 13876
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetUser;->userId:J

    .line 13877
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 13881
    const v0, 0x42999c0b

    return v0
.end method
