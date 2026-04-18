.class public Lorg/drinkless/tdlib/TdApi$MessageFileTypeGroup;
.super Lorg/drinkless/tdlib/TdApi$MessageFileType;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MessageFileTypeGroup"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = -0xd1a7098


# instance fields
.field public title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 16440
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageFileType;-><init>()V

    .line 16441
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "str"    # Ljava/lang/String;

    .line 16431
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$MessageFileType;-><init>()V

    .line 16432
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$MessageFileTypeGroup;->title:Ljava/lang/String;

    .line 16433
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 16437
    const v0, -0xd1a7098

    return v0
.end method
