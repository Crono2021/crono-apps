.class public Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicReactions;
.super Lorg/drinkless/tdlib/TdApi$Function;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "ReadAllForumTopicReactions"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lorg/drinkless/tdlib/TdApi$Function<",
        "Lorg/drinkless/tdlib/TdApi$Ok;",
        ">;"
    }
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x76679185


# instance fields
.field public chatId:J

.field public forumTopicId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 29768
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29769
    return-void
.end method

.method public constructor <init>(JI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "i9"    # I

    .line 29758
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Function;-><init>()V

    .line 29759
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicReactions;->chatId:J

    .line 29760
    iput p3, p0, Lorg/drinkless/tdlib/TdApi$ReadAllForumTopicReactions;->forumTopicId:I

    .line 29761
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 29765
    const v0, -0x76679185

    return v0
.end method
