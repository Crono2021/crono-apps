.class public Lorg/drinkless/tdlib/TdApi$MessageAnimatedEmoji;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageAnimatedEmoji"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x3621f5e2


# instance fields
.field public animatedEmoji:Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;

.field public emoji:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28204
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28205
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;Ljava/lang/String;)V
    .locals 0
    .param p1, "animatedEmoji"    # Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;
    .param p2, "str"    # Ljava/lang/String;

    .line 28194
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 28195
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimatedEmoji;->animatedEmoji:Lorg/drinkless/tdlib/TdApi$AnimatedEmoji;

    .line 28196
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageAnimatedEmoji;->emoji:Ljava/lang/String;

    .line 28197
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28201
    const v0, 0x3621f5e2

    return v0
.end method
