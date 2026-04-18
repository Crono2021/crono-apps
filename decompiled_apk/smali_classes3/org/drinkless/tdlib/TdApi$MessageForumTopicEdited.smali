.class public Lorg/drinkless/tdlib/TdApi$MessageForumTopicEdited;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageForumTopicEdited"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0xc0b780


# instance fields
.field public editIconCustomEmojiId:Z

.field public iconCustomEmojiId:J

.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38524
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38525
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZJ)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;
    .param p2, "z8"    # Z
    .param p3, "j5"    # J

    .line 38513
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38514
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicEdited;->name:Ljava/lang/String;

    .line 38515
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicEdited;->editIconCustomEmojiId:Z

    .line 38516
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$MessageForumTopicEdited;->iconCustomEmojiId:J

    .line 38517
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38521
    const v0, 0xc0b780

    return v0
.end method
