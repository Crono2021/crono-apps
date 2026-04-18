.class public Lorg/drinkless/tdlib/TdApi$UpdateChatTheme;
.super Lorg/drinkless/tdlib/TdApi$Update;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "UpdateChatTheme"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x60decde3


# instance fields
.field public chatId:J

.field public theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 34348
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34349
    return-void
.end method

.method public constructor <init>(JLorg/drinkless/tdlib/TdApi$ChatTheme;)V
    .locals 0
    .param p1, "j5"    # J
    .param p3, "chatTheme"    # Lorg/drinkless/tdlib/TdApi$ChatTheme;

    .line 34338
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Update;-><init>()V

    .line 34339
    iput-wide p1, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatTheme;->chatId:J

    .line 34340
    iput-object p3, p0, Lorg/drinkless/tdlib/TdApi$UpdateChatTheme;->theme:Lorg/drinkless/tdlib/TdApi$ChatTheme;

    .line 34341
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 34345
    const v0, -0x60decde3

    return v0
.end method
