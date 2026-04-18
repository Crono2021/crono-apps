.class public Lorg/drinkless/tdlib/TdApi$UpdateMessageMentionRead;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateMessageMentionRead"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xf08b2ba


# instance fields
.field public chatId:J

.field public messageId:J

.field public unreadMentionCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 41780
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41781
    return-void
.end method

.method public constructor <init>(JJI)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "j9"    # J
    .param p5, "i9"    # I

    .line 41769
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 41770
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageMentionRead;->chatId:J

    .line 41771
    iput-wide p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageMentionRead;->messageId:J

    .line 41772
    iput p5, p0, Lorg/drinkless/tdlib/TdApi$UpdateMessageMentionRead;->unreadMentionCount:I

    .line 41773
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 41777
    const v0, -0xf08b2ba

    return v0
.end method
