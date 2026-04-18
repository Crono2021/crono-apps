.class public Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ChatFolderInviteLink"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x1d7160fd


# instance fields
.field public chatIds:[J

.field public inviteLink:Ljava/lang/String;

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 36102
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36103
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;[J)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "str2"    # Ljava/lang/String;
    .param p3, "jArr"    # [J

    .line 36091
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 36092
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;->inviteLink:Ljava/lang/String;

    .line 36093
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;->name:Ljava/lang/String;

    .line 36094
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$ChatFolderInviteLink;->chatIds:[J

    .line 36095
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 36099
    const v0, 0x1d7160fd

    return v0
.end method
