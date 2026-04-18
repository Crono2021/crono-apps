.class public Lorg/drinkless/tdlib/TdApi$MessageCalendarDay;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageCalendarDay"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1670709e


# instance fields
.field public message:Lorg/drinkless/tdlib/TdApi$Message;

.field public totalCount:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 28284
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28285
    return-void
.end method

.method public constructor <init>(ILorg/drinkless/tdlib/TdApi$Message;)V
    .locals 0
    .param p1, "i9"    # I
    .param p2, "message"    # Lorg/drinkless/tdlib/TdApi$Message;

    .line 28274
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 28275
    iput p1, p0, Lorg/drinkless/tdlib/TdApi$MessageCalendarDay;->totalCount:I

    .line 28276
    iput-object p2, p0, Lorg/drinkless/tdlib/TdApi$MessageCalendarDay;->message:Lorg/drinkless/tdlib/TdApi$Message;

    .line 28277
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 28281
    const v0, -0x1670709e

    return v0
.end method
