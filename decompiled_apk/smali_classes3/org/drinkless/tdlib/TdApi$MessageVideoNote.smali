.class public Lorg/drinkless/tdlib/TdApi$MessageVideoNote;
.super Lorg/drinkless/tdlib/TdApi$MessageContent;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageVideoNote"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x396b2486


# instance fields
.field public isSecret:Z

.field public isViewed:Z

.field public videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 38722
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38723
    return-void
.end method

.method public constructor <init>(Lorg/drinkless/tdlib/TdApi$VideoNote;ZZ)V
    .locals 0
    .param p1, "videoNote"    # Lorg/drinkless/tdlib/TdApi$VideoNote;
    .param p2, "z8"    # Z
    .param p3, "z9"    # Z

    .line 38711
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageContent;-><init>()V

    .line 38712
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoNote;->videoNote:Lorg/drinkless/tdlib/TdApi$VideoNote;

    .line 38713
    iput-boolean p2, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoNote;->isViewed:Z

    .line 38714
    iput-boolean p3, p0, Lorg/drinkless/tdlib/TdApi$MessageVideoNote;->isSecret:Z

    .line 38715
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 38719
    const v0, 0x396b2486

    return v0
.end method
