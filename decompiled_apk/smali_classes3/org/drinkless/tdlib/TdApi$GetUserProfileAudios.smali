.class public Lorg/drinkless/tdlib/TdApi$GetUserProfileAudios;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "GetUserProfileAudios"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Audios;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xc733236


# instance fields
.field public limit:I

.field public offset:I

.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 37622
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37623
    return-void
.end method

.method public constructor <init>(JII)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I
    .param p4, "i10"    # I

    .line 37611
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 37612
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfileAudios;->userId:J

    .line 37613
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfileAudios;->offset:I

    .line 37614
    iput p4, p0, Lorg/drinkless/tdlib/TdApi$GetUserProfileAudios;->limit:I

    .line 37615
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 37619
    const v0, -0xc733236

    return v0
.end method
