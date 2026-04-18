.class public Lorg/drinkless/tdlib/TdApi$MessageFileTypePrivate;
.super Lorg/drinkless/tdlib/TdApi$MessageFileType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageFileTypePrivate"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0x1f1bb12c


# instance fields
.field public name:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16458
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageFileType;-><init>()V

    .line 16459
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16449
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageFileType;-><init>()V

    .line 16450
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageFileTypePrivate;->name:Ljava/lang/String;

    .line 16451
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16455
    const v0, -0x1f1bb12c

    return v0
.end method
