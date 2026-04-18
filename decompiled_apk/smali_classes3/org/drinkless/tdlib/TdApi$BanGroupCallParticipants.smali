.class public Lorg/drinkless/tdlib/TdApi$BanGroupCallParticipants;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "BanGroupCallParticipants"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x253ef5e5


# instance fields
.field public groupCallId:I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 23104
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23105
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 23094
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 23095
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$BanGroupCallParticipants;->groupCallId:I

    .line 23096
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$BanGroupCallParticipants;->userIds:[J

    .line 23097
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 23101
    const v0, 0x253ef5e5

    return v0
.end method
