.class public Lorg/drinkless/tdlib/TdApi$CreateForumTopic;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CreateForumTopic"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$ForumTopicInfo;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xe89377


# instance fields
.field public chatId:J

.field public icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

.field public isNameImplicit:Z

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 42942
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42943
    return-void
.end method

.method public constructor <init>(JLjava/lang/String;ZLorg/drinkless/tdlib/TdApi$ForumTopicIcon;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "str"    # Ljava/lang/String;
    .param p4, "z8"    # Z
    .param p5, "forumTopicIcon"    # Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

    .line 42930
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 42931
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$CreateForumTopic;->chatId:J

    .line 42932
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$CreateForumTopic;->name:Ljava/lang/String;

    .line 42933
    iput-boolean p4, p0, Lorg/drinkless/tdlib/TdApi$CreateForumTopic;->isNameImplicit:Z

    .line 42934
    iput-object p5, p0, Lorg/drinkless/tdlib/TdApi$CreateForumTopic;->icon:Lorg/drinkless/tdlib/TdApi$ForumTopicIcon;

    .line 42935
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 42939
    const v0, -0xe89377

    return v0
.end method
