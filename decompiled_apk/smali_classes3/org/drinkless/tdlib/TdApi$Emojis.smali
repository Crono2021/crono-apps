.class public Lorg/drinkless/tdlib/TdApi$Emojis;
.super Lorg/drinkless/tdlib/TdApi$Object;
.source "TdApi.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lorg/drinkless/tdlib/TdApi;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Emojis"
.end annotation


# static fields
.field public static final CONSTRUCTOR:I = 0x38a507e0


# instance fields
.field public emojis:[Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 11814
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11815
    return-void
.end method

.method public constructor <init>([Ljava/lang/String;)V
    .locals 0
    .param p1, "strArr"    # [Ljava/lang/String;

    .line 11805
    invoke-direct {p0}, Lorg/drinkless/tdlib/TdApi$Object;-><init>()V

    .line 11806
    iput-object p1, p0, Lorg/drinkless/tdlib/TdApi$Emojis;->emojis:[Ljava/lang/String;

    .line 11807
    return-void
.end method


# virtual methods
.method public getConstructor()I
    .locals 1

    .line 11811
    const v0, 0x38a507e0

    return v0
.end method
