.class public Lorg/drinkless/tdlib/TdApi$InviteVideoChatParticipants;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "InviteVideoChatParticipants"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1c33af72


# instance fields
.field public groupCallId:I

.field public userIds:[J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 27844
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 27845
    return-void
.end method

.method public constructor <init>(I[J)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "jArr"    # [J

    .line 27834
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 27835
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$InviteVideoChatParticipants;->groupCallId:I

    .line 27836
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$InviteVideoChatParticipants;->userIds:[J

    .line 27837
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 27841
    const v0, -0x1c33af72

    return v0
.end method
