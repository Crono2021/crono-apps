.class public Lorg/drinkless/tdlib/TdApi$MessageChatDeleteMember;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageChatDeleteMember"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x37e931a9


# instance fields
.field public userId:J


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16314
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16315
    return-void
.end method

.method public constructor <init>(J)V
    .locals 0
    .param p1, "j5"    # J

    .line 16305
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 16306
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$MessageChatDeleteMember;->userId:J

    .line 16307
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16311
    const v0, 0x37e931a9

    return v0
.end method
